package tobi4972.olympiade.service;

import java.util.Optional;
import java.util.Set;

public interface CrudService<T, ID> {
    Set<T> findAll();
    T save(T object);
    void deleteBy(ID id);
    Optional<T> findById(ID id);
}
