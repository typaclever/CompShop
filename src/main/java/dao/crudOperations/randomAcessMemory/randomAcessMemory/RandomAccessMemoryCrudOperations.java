package dao.crudOperations.randomAcessMemory.randomAcessMemory;

import entity.randomAccessMemory.mainEntity.RandomAccessMemory;

import java.util.List;
import java.util.Set;

public interface RandomAccessMemoryCrudOperations {
    RandomAccessMemory getRandomAccessMemoryById(Long id);
    void deleteRandomAccessMemory(Long id);
    void saveRandomAccessMemory(RandomAccessMemory ram);
    List<RandomAccessMemory> getAllRandomAccessMemories();
    void updateRandomAccessMemory(RandomAccessMemory ram);
}
