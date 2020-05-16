package homework;

public enum Grade {

    GRADE_ONE(1, "优秀"),
    GREAD_TWO(2, "良好"),
    GRADE_THREE(3, "中等"),
    GRADE_FOUR(4, "及格"),
    GRADE_FIVE(5, "不及格");

    private final int grade;
    private final String msg;

    Grade(int grade, String msg) {
        this.grade = grade;
        this.msg = msg;
    }

    public int getGrade() {
        return grade;
    }

    public String getMsg() {
        return msg;
    }
}
