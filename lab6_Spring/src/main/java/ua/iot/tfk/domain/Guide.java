package ua.iot.tfk.domain;


import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "guide")
public class Guide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_guide")
    private Integer idGuide;

    @Column(name = "guide_name")
    private String guideName;

    @Column(name = "guide_date_work")
    private String guideDateWork;

    @Column(name = "guide_num_phone")
    private String guideNumPhone;

    public Guide() {
    }

    public Guide(String guideName,String guideDateWork,String guideNumPhone  ){
        this(-1, guideName,guideDateWork,guideNumPhone);
    }

    public Guide(Integer idGuide, String guideName,String guideDateWork,String guideNumPhone) {
        this.idGuide = idGuide;
        this.guideName = guideName;
        this.guideDateWork=guideDateWork;
        this.guideNumPhone=guideNumPhone;
    }

    public Integer getId() {
        return idGuide;
    }

    public void setId(Integer idGuide) {
        this.idGuide = idGuide;
    }

    public String getGuideName() {
        return guideName;
    }

    public void setGuideName(String guideName) {
        this.guideName = guideName;
    }

    public String getGuideDateWork() {
        return guideDateWork;
    }

    public void setGuideDateWork(String guideDateWork) {
        this.guideDateWork = guideDateWork;
    }

    public String getGuideNumPhone() {
        return guideNumPhone;
    }

    public void setGuideNumPhone(String guideNumPhone) {
        this.guideNumPhone = guideNumPhone;
    }




    @Override
    public String toString() {
        return "Guide{" +
                "id=" + idGuide +
                ", guideDateWork=" + guideDateWork +
                ", guideNumPhone=" + guideNumPhone +
                ", guideName='" + guideName + '\'' +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Guide)) return false;
        Guide guide = (Guide) o;
        return idGuide.equals(guide.idGuide) &&
                guideName.equals(guide.guideName) &&
                guideDateWork.equals(guide.guideDateWork) &&
                guideNumPhone.equals(guide.guideNumPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGuide, guideName, guideDateWork, guideNumPhone);
    }
}
