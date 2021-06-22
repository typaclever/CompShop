package dao.SessionFactoryAccess;

import entity.graphics.*;
import entity.graphics.mainEntity.Graphics;
import entity.memory.*;
import entity.memory.mainEntity.Memory;
import entity.operationSystem.OSBrand;
import entity.operationSystem.mainEntity.OperationSystem;
import entity.processor.Model;
import entity.processor.ProcessorBrand;
import entity.processor.ProcessorFamily;
import entity.processor.Series;
import entity.processor.mainEntity.Processor;
import entity.randomAccessMemory.MemoryType;
import entity.randomAccessMemory.RAMBrand;
import entity.randomAccessMemory.mainEntity.RandomAccessMemory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryAccess {
    private static SessionFactory sessionFactory;

    private SessionFactoryAccess() {
    }

    private static SessionFactory getSessionFactory() {
        return sessionFactory != null
                ? sessionFactory
                : (sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Processor.class)
                .addAnnotatedClass(Model.class)
                .addAnnotatedClass(ProcessorBrand.class)
                .addAnnotatedClass(ProcessorFamily.class)
                .addAnnotatedClass(Series.class)
                .addAnnotatedClass(Memory.class)
                .addAnnotatedClass(SSD.class)
                .addAnnotatedClass(HDD.class)
                .addAnnotatedClass(ConnectionInterface.class)
                .addAnnotatedClass(FormFactor.class)
                .addAnnotatedClass(MemoryBrand.class)
                .addAnnotatedClass(MemoryCellType.class)
                .addAnnotatedClass(RandomAccessMemory.class)
                .addAnnotatedClass(MemoryType.class)
                .addAnnotatedClass(RAMBrand.class)
                .addAnnotatedClass(Graphics.class)
                .addAnnotatedClass(GPUManufacturer.class)
                .addAnnotatedClass(GraphicsBrand.class)
                .addAnnotatedClass(GraphicsChip.class)
                .addAnnotatedClass(GraphicsFamily.class)
                .addAnnotatedClass(Purpose.class)
                .addAnnotatedClass(OperationSystem.class)
                .addAnnotatedClass(OSBrand.class)
                .buildSessionFactory());
    }

}
