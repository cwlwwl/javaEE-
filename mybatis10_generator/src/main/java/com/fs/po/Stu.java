package com.fs.po;

public class Stu {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column stu.id
     *
     * @mbggenerated Tue Jul 16 13:55:22 GMT+08:00 2019
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column stu.name
     *
     * @mbggenerated Tue Jul 16 13:55:22 GMT+08:00 2019
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column stu.sex
     *
     * @mbggenerated Tue Jul 16 13:55:22 GMT+08:00 2019
     */
    private String sex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column stu.age
     *
     * @mbggenerated Tue Jul 16 13:55:22 GMT+08:00 2019
     */
    private Integer age;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column stu.id
     *
     * @return the value of stu.id
     *
     * @mbggenerated Tue Jul 16 13:55:22 GMT+08:00 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column stu.id
     *
     * @param id the value for stu.id
     *
     * @mbggenerated Tue Jul 16 13:55:22 GMT+08:00 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column stu.name
     *
     * @return the value of stu.name
     *
     * @mbggenerated Tue Jul 16 13:55:22 GMT+08:00 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column stu.name
     *
     * @param name the value for stu.name
     *
     * @mbggenerated Tue Jul 16 13:55:22 GMT+08:00 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column stu.sex
     *
     * @return the value of stu.sex
     *
     * @mbggenerated Tue Jul 16 13:55:22 GMT+08:00 2019
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column stu.sex
     *
     * @param sex the value for stu.sex
     *
     * @mbggenerated Tue Jul 16 13:55:22 GMT+08:00 2019
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column stu.age
     *
     * @return the value of stu.age
     *
     * @mbggenerated Tue Jul 16 13:55:22 GMT+08:00 2019
     */
    public Integer getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column stu.age
     *
     * @param age the value for stu.age
     *
     * @mbggenerated Tue Jul 16 13:55:22 GMT+08:00 2019
     */
    public void setAge(Integer age) {
        this.age = age;
    }
}