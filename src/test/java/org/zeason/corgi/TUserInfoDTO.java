package org.zeason.corgi;

/**
 * @Author: Zuo Yichen
 * @Date: 2019/10/21 23:13
 */
public class TUserInfoDTO {
    private Integer id;
    private String name;
    /**
     * 1 male 2 female 0 unknown
     */
    private String sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
