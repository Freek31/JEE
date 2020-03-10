package controleur.commandes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.exceptions.DAOException;



public interface ICommand {
    public void execute(HttpServletRequest request, 
            HttpServletResponse response) 
        throws ServletException, IOException, DAOException;
}
