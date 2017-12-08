Project Servlet work with a database servlets from browser.
To start the project, you need to create a database named servlets. Code for filling the database is in src\main\resources\database
All properties for attach the DB to project are put by path: scr/main/resources/hibernate.cfg.xml.
Information about mapping to servlets are in scr/main/webapp/WEB-INF/web.xml.
The link in browser "http://localhost:8080/welcome?" send to the main menu, where you could chose working area with: or Manufacturer, or Product.
When you've choose some link, you enter to the next link.
This application add, read, update or delete the chosen object.