package dao.crudOperations.memory.connectionInterface;

import entity.memory.ConnectionInterface;

import java.util.List;
import java.util.Set;

public interface ConnectionInterfaceCrudOperations {
    ConnectionInterface getConnectionInterfaceById(Long id);

    void deleteConnectionInterface(Long id);

    void saveConnectionInterface(ConnectionInterface connectionInterface);

    List<ConnectionInterface> getAllConnectionInterfaces();

    void updateConnectionInterface(ConnectionInterface connectionInterface);
}
