package pl.xayan.tau.tau1.DI;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class AbstractRepository<T extends EntityInterface> implements RepositoryInterface<T> {
    private List<T> entityList = new ArrayList<>();

    public void insert(T entity) {
        int maxId = entityList
                .stream()
                .map(EntityInterface::getId)
                .max(Comparator.comparingInt(e -> e))
                .orElse(0);

        entity.setId(maxId + 1);

        entityList.add(entity);
    }

    public List<T> getAll()
    {
        return entityList;
    }

    public T getById(int id) {
        return entityList
                .stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return entityList.size();
    }

    public void update(int id, T entity) {
        T element = entityList
                .stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);

        if(!entityList.contains(element)) {
            this.insert(entity);
            return;
        }

        int elementIndex = entityList.indexOf(element);

        entity.setId(id);
        entityList.set(elementIndex, entity);
    }

    public void delete(T entity) {
        entityList.remove(entity);
    }
}