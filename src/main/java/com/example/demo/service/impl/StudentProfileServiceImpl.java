@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository repo;
    private final IntegrityCaseRepository caseRepo;
    private final RepeatOffenderRecordRepository recordRepo;
    private final RepeatOffenderCalculator calc;

    public StudentProfileServiceImpl(
            StudentProfileRepository r,
            IntegrityCaseRepository c,
            RepeatOffenderRecordRepository rr,
            RepeatOffenderCalculator calc) {
        this.repo = r;
        this.caseRepo = c;
        this.recordRepo = rr;
        this.calc = calc;
    }

    public StudentProfile createStudent(StudentProfile s) {
        s.setRepeatOffender(false);
        return repo.save(s);
    }

    public StudentProfile getStudentById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
    }

    public List<StudentProfile> getAllStudents() {
        return repo.findAll();
    }

    public StudentProfile updateRepeatOffenderStatus(Long id) {
        StudentProfile s = getStudentById(id);
        List<IntegrityCase> cases = caseRepo.findByStudentProfile(s);

        RepeatOffenderRecord rec =
                calc.computeRepeatOffenderRecord(s, cases);

        s.setRepeatOffender(rec.getTotalCases() >= 2);
        recordRepo.save(rec);

        return repo.save(s);
    }
}
