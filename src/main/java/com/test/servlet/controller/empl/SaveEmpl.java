package com.test.servlet.controller.empl;

import com.test.servlet.controller.InternalController;

import com.test.servlet.exception.ValidationException;
import com.test.servlet.model.Employee;

import com.test.servlet.service.EmployeeService;

import com.test.servlet.service.impl.EmployeeServiceImpl;
import com.test.servlet.util.ValidatorUtils;
import net.sf.oval.Validator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


public class SaveEmpl implements InternalController {


    private EmployeeService empServ =  new EmployeeServiceImpl();


    public void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Employee empl = new Employee();
        empl.setFirstName(request.getParameter("firstName"));
        empl.setSecondName(request.getParameter("secondName"));
       // empl.setBirthday(Date.valueOf(request.getParameter("birthday")));
       String date2 = request.getParameter("birthday");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date birthday = dateFormat.parse(request.getParameter("birthday"));
            empl.setBirthday(birthday);
        }catch (ParseException e)
        {

        }

        String str = request.getParameter("id");
        empl.setDepId(Integer.parseInt((request.getParameter("depId"))));
        try {
            ValidatorUtils util = new ValidatorUtils();
            util.validate(empl);
            if(request.getParameter("id").isEmpty())
            {
                empServ.add(empl);
            }
            else
            {
                empl.setId(Integer.valueOf(request.getParameter("id")));
                empServ.update(empl);
            }
         }catch (SQLException e) {
            e.printStackTrace();
        }catch (ValidationException e)
        {
            Map<String, String> error = e.getError();
            request.setAttribute("error", error);
            request.setAttribute("depId", request.getParameter("depId"));
            request.setAttribute("employee", empl );
            request.getRequestDispatcher("empl/create.jsp").forward(request, response);
        }
        String url ="/showAllEmpl?depId="+request.getParameter("depId");
        response.sendRedirect(url);
    }
}