package ra.model;

import java.time.LocalDate;
import java.util.Scanner;

public class Subject {
    private String subjectId;
    private String subjectName;

    public Subject() {
    }

    public Subject(String subjectId, String subjectName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void inputDataSubject(Scanner sc, Subject[] subjects, int currentIndex) {

        boolean isExistSubId = true;
        do {
            System.out.println("Nhập vào mã môn học");
            String inputSubId = sc.nextLine();

            if (inputSubId.matches("^MH[0-9]{3}$")) {
                boolean checkId = false;
                for (int i = 0; i < currentIndex; i++) {
                    if (subjects[i] != null && subjects[i].getSubjectId().equals(inputSubId)) {
                        checkId = true;
                        break;
                    }
                }

                if (!checkId) {
                    this.subjectId = inputSubId;
                    isExistSubId = false;
                } else {
                    System.out.println("Mã môn học đã có trong danh sách, mời nhập lại");
                }

            } else {
                System.out.println("Mã môn học phải bắt đầu bằng MH và 3 kí tự số bất kì,vu lòng nhập lại");
            }
        }while (isExistSubId);


            boolean isExistSubName = true;
            do {
                System.out.println("Nhập vào tên môn học");
                String inputSubName = sc.nextLine();
                if (!inputSubName.trim().isEmpty()) {
                    boolean checkName = false;
                    for (int i = 0; i < currentIndex; i++) {
                        if (subjects[i] != null && subjects[i].getSubjectId().equals(inputSubName)) {
                            checkName = true;
                            break;
                        }
                    }
                    if (!checkName) {
                        this.subjectName = inputSubName;
                        isExistSubName = false;
                    } else {
                        System.out.println("Tên môn học đã bị trùng, vui lòng nhập lại");
                    }
                } else {
                    System.out.println("Tên môn học không được để trống, vui lòng nhập lại");
                }
            } while (isExistSubName);




    }

    public void displayDataSubject() {
        System.out.printf("Mã môn học: %s, Tên môn học: %s \n",this.subjectId,this.subjectName);
    }
}
