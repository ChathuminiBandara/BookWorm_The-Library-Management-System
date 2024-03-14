package lk.ijse.model;

import lk.ijse.db.Dbconnection;
import lk.ijse.dto.bookDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class bookModel {


    public boolean saveBook(bookDto dto) throws SQLException {
        Connection connection = Dbconnection.getInstance().getConnection();

        String sql = "INSERT INTO book VALUES(?, ?, ?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getName());
        pstm.setString(2, dto.getAuthor());
        pstm.setString(3, dto.getYear());
        pstm.setString(4, dto.getId());
        pstm.setString(5, dto.getCount());

        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;
    }


    public boolean deleteBook(String id) throws SQLException {
        Connection connection = Dbconnection.getInstance().getConnection();

        String sql = "DELETE FROM book WHERE name = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, id);

        return pstm.executeUpdate() > 0;
    }

    public boolean updateBook(bookDto dto) throws SQLException {
        Connection connection = Dbconnection.getInstance().getConnection();

        String sql = "UPDATE book SET author = ?, year = ?, id = ?, count =? WHERE name = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, dto.getAuthor());
        pstm.setString(2, dto.getYear());
        pstm.setString(3, dto.getId());
        pstm.setString(4, dto.getCount());

        return pstm.executeUpdate() > 0;
    }


    public List<bookDto> getAllBook() throws SQLException {
        Connection connection = Dbconnection.getInstance().getConnection();

        String sql = "SELECT * FROM book";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        ArrayList<bookDto> dtoList = new ArrayList<>();

        while(resultSet.next()) {
            dtoList.add(
                    new bookDto(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5)
                    )
            );
        }
        return dtoList;
    }

}
