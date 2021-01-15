# Scheduler Based Mail Sending

# Functionality covered:                                                                                                               
This Repository includes following functionality:                                                                                       

`1` : Implemented Quartz Scheduler.                                                                                                    
`2` : Sending Mail based on batch wise using Scheduler timings.                                                                        
`3` : Implemented Spring security.                                                                                                      
`4` : Implemeted dynamic log file creation based on log4j configuration.                                                                          
`5` : Implemented user alert messages using bootstrap.                                                                                        

# Steps to Run this repository:                                                                                                         
`step 1`: Dowmload this repository & do maven import.                                                                                   
`step 2`: Execute the Query as listed in db_scripts.sql file to any Data base.                                                             
`step 3`: Add jndi-name in server as defined in data-source.config.xml  
`step 4`: Configure the JNDI in Wildfly. For the reference follow the below steps
   
	
  `a.` Configuring your JNDI data source(s) on WildFly 10 requires that you edit the standalone.xml configuration file of your application server, which can be found at the following location ; `/wildfly-10-Final/standalone/configuration`

  `b.` You can copy and paste our datasource examples, then edit them to your configuration as required. The datasources must be defined between the <datasources> tags of the standalone.xml file.

``<datasource jndi-name="java:/GPWorkflowDS" pool-name="GPWorkflowDS-Pool" enabled="true" use-java-context="true">
    <connection-url>jdbc:oracle:thin:@localhost:1521:ORCL1</connection-url>
    <driver>ojdbc7</driver>
    <pool>
        <min-pool-size>5</min-pool-size>
        <max-pool-size>200</max-pool-size>
        <prefill>true</prefill>
    </pool>
    <security>
        <user-name>GPWORKFLOW</user-name>
        <password>GPWORKFLOW</password>
    </security>
</datasource>
``

`step 5`: Configure your Gmail credentials in `email-config.xml` for sending email.                                                         
`step 6`: Run the Application, if it successfully deployed means you will redirected to login page with registration link.            
`step 7`: Click on registration link & register the data & mail will go to registered mail account with the scheduled timings.                                     

# Technology Used:    
  Java 8                                                                                                                                
  Spring MVC                                                                                                                             
  JPA & Hibernate                                                                                                                       
  Spring-security                                                                                                                                                                                                                                                       
  Quartz Scheduler                                                                                                                    
  Java Mail API                                                                                                                          
  Thymeleaf   
  Log4j    
  
 # Tools Used
  Eclipse- Mars
  Server - Wildfly 10                                                                                                                   

 ## User Guide
 
 <img src="https://github.com/Sudarshan-Gowda/Spring-Mvc-Quartz-Scheduler/blob/master/docs/Picture1.PNG"/>
 
 <img src="https://github.com/Sudarshan-Gowda/Spring-Mvc-Quartz-Scheduler/blob/master/docs/Picture2.PNG"/>

<img src="https://github.com/Sudarshan-Gowda/Spring-Mvc-Quartz-Scheduler/blob/master/docs/Picture2.PNG"/>

<img src="https://github.com/Sudarshan-Gowda/Spring-Mvc-Quartz-Scheduler/blob/master/docs/Picture4.PNG"/>

<img src="https://github.com/Sudarshan-Gowda/Spring-Mvc-Quartz-Scheduler/blob/master/docs/Picture5.PNG"/>

<img src="https://github.com/Sudarshan-Gowda/Spring-Mvc-Quartz-Scheduler/blob/master/docs/Picture6.PNG"/>

<img src="https://github.com/Sudarshan-Gowda/Spring-Mvc-Quartz-Scheduler/blob/master/docs/Picture7.PNG"/>

<img src="https://github.com/Sudarshan-Gowda/Spring-Mvc-Quartz-Scheduler/blob/master/docs/Picture8.PNG"/>

<img src="https://github.com/Sudarshan-Gowda/Spring-Mvc-Quartz-Scheduler/blob/master/docs/Picture9.PNG"/>



# Contributing

The [issue tracker](https://github.com/Sudarshan-Gowda/Spring-Mvc-Quartz-Scheduler/issues) is the preferred channel for bug reports, features requests and submitting pull requests.
