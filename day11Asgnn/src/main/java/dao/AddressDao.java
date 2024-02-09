package dao;

import java.util.*;
import pojos.Address;

public interface AddressDao {
    String enterEmpAddress(long empId, Address newAdr);
    String displayEmployeeAddress(long empId);
    List<String> displayLastNameOfEmpAndAddress(String lastCity);
}
