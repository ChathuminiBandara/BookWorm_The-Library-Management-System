package lk.ijse.dto;

public class bookDto {

    private String Name;
    private String Count;
    private String Author;
    private String Year;
    private String Id;


    public bookDto(String name, String author, String year, String id, String count) {
        Name = name;
        Author = author;
        Year = year;
        Id = id;
        Count = count;
    }

    public bookDto() {
    }
    public String getCount() {return Count;}

    public void setCount(String count) {Count = count;}

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getYear() {return Year;}

    public void setYear(String year) {
        Year = year;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }




}
