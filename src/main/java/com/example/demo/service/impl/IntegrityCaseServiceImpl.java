@Service
public class IntegrityCaseServiceImpl {

    private final IntegrityCaseRepository repository;

    public IntegrityCaseServiceImpl(IntegrityCaseRepository repository) {
        this.repository = repository;
    }

    public IntegrityCase createCase(IntegrityCase integrityCase) {
        return repository.save(integrityCase);
    }
}
