/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logicas.Logica;

/**
 *
 * @author strudel
 */

@WebServlet("/mvc")
public class ServletMVC extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String parametro = request.getParameter("logica");
       // if (!parametro.contains("Get") || !parametro.contentEquals("LoginLogica") || !parametro.contentEquals("CadastroLogica")) {
           // if (!LoginLogica.checkCredential(request)) {
            //    response.setStatus(401);
             //   return;
            //}
       // }
        String nomeDaClasse = "logicas." + parametro;
        try {
            Class classe = Class.forName(nomeDaClasse);
            Logica logica = (Logica) classe.newInstance();
            logica.executa(request, response);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
