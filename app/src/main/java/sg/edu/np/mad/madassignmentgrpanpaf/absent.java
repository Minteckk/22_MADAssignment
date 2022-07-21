package sg.edu.np.mad.madassignmentgrpanpaf;

public class absent {
    String startDate;
    String endDate;
    String DateOfIssue;
    String ClinicNo;
    String ClinicNumber;
    String StudentID;
    String AbsenceReason;
    String AbsenceFrom;

    public absent(String startDate, String endDate, String dateOfIssue, String clinicNo, String clinicNumber,
                  String studentID, String selectedItem, String selectedAbsenceType)
    {
        this.startDate = startDate;
        this.endDate = endDate;
        this.DateOfIssue = dateOfIssue;
        this.ClinicNo = clinicNo;
        this.ClinicNumber = clinicNumber;
        this.StudentID = studentID;
        this.AbsenceReason = selectedItem;
        this.AbsenceFrom = selectedAbsenceType;
    }

    public absent() { }



    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDateOfIssue() {
        return DateOfIssue;
    }

    public void setDateOfIssue(String dateOfIssue) {
        DateOfIssue = dateOfIssue;
    }

    public String getClinicNo() {
        return ClinicNo;
    }

    public void setClinicNo(String clinicNo) {
        ClinicNo = clinicNo;
    }

    public String getClinicNumber() {
        return ClinicNumber;
    }

    public void setClinicNumber(String clinicNumber) {
        ClinicNumber = clinicNumber;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public String getAbsenceReason() {
        return AbsenceReason;
    }

    public void setAbsenceReason(String absenceReason) {
        AbsenceReason = absenceReason;
    }

    public String getAbsenceFrom() {
        return AbsenceFrom;
    }

    public void setAbsenceFrom(String absenceFrom) {
        AbsenceFrom = absenceFrom;
    }
}
