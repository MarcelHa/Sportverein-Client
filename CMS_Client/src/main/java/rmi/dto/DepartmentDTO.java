package rmi.dto;


public class DepartmentDTO {
    private String _deptName;
    private int _deptId;
    private int _headOfDeptId;
    private PersonDTO _personDTO;

    public String getDeptName() {
        return _deptName;
    }

    public void setDeptName(String deptName) {
        _deptName = deptName;
    }

    public int getDeptId() {
        return _deptId;
    }

    public void setDeptId(int deptId) {
        _deptId = deptId;
    }

    public int getHeadOfDeptId() {
        return _headOfDeptId;
    }

    public void setHeadOfDeptId(int headOfDeptId) {
        _headOfDeptId = headOfDeptId;
    }

    public PersonDTO getPersonDTO() {
        return _personDTO;
    }

    public void setPersonDTO(PersonDTO personDTO) {
        _personDTO = personDTO;
    }
}
