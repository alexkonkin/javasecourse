package com.globallogic.javase.university.businessObjects;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 2/15/13
 * Time: 1:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class Auditorium {
    private Integer auditoriumId;
    private Integer campusId;
    private Integer floorId;
    private Integer auditoriumNumber;
    private String textComment;

    public Auditorium(){
        auditoriumId = 0;
        campusId = 0;
        floorId = 0;
        auditoriumNumber = 0;
        textComment = "-";
    }

    public Auditorium(Integer aId,Integer cId, Integer fId, Integer aNumber, String tComment){
        auditoriumId = aId;
        campusId = cId;
        floorId = fId;
        auditoriumNumber = aNumber;
        textComment = tComment;
    }

    public void setAuditoriumId(Integer aId){
        auditoriumId = aId;
    }

    public void setCampusId(Integer cId){
        campusId = cId;
    }

    public void setFloorId (Integer fId){
        floorId = fId;
    }

    public void setAuditoriumNumber(Integer aNumber){
        auditoriumNumber = aNumber;
    }

    public void setTextComment(String tComment){
        textComment = tComment;
    }

    public  Integer getAuditoriumId(){
        return auditoriumId;
    }

    public Integer getCampusId(){
        return campusId;
    }

    public Integer getFloorId (){
        return floorId;
    }

    public Integer getAuditoriumNumber(){
        return auditoriumNumber;
    }

    public String getTextComment(){
        return textComment;
    }
}
