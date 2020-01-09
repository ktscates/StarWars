//
//package com.example.starwars;
//
//import java.util.List;
//import com.google.gson.annotations.Expose;
//import com.google.gson.annotations.SerializedName;
//
//public class CharactersSearch {
//
//    @SerializedName("status")
//    @Expose
//    private Integer status;
//    @SerializedName("message")
//    @Expose
//    private String message;
//    @SerializedName("data")
//    @Expose
//    private List<Datum> data = null;
//
//    /**
//     * No args constructor for use in serialization
//     *
//     */
//    public CharactersSearch() {
//    }
//
//    /**
//     *
//     * @param data
//     * @param message
//     * @param status
//     */
//    public CharactersSearch(Integer status, String message, List<Datum> data) {
//        super();
//        this.status = status;
//        this.message = message;
//        this.data = data;
//    }
//
//    public Integer getStatus() {
//        return status;
//    }
//
//    public void setStatus(Integer status) {
//        this.status = status;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public List<Datum> getData() {
//        return data;
//    }
//
//    public void setData(List<Datum> data) {
//        this.data = data;
//    }
//
//}
