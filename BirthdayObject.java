public class BirthdayObject implements Comparable<BirthdayObject> {
    private String fullName;
    private String birthday;

    public BirthdayObject(String fullName_, String birthday_) {
        this.fullName = fullName_;
        this.birthday = birthday_;
    }

    public static BirthdayObject createFromString(String line) {
        String[] info = line.split("\\|");
        return new BirthdayObject(info[0], info[1]);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public int compareTo(BirthdayObject o) {
        return this.birthday.compareTo(o.getBirthday());
    }

    public String toString() {
        return this.fullName + "|" + this.birthday;
    }
}
