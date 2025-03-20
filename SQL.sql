

create  database Xconstracteur ;
        use Xconstracteur ;


create  table Project(
                         projectId int primary key  auto_increment,
                         name varchar(100) ,
                         description varchar(200),
                         startdate Date ,
                         enddate Date ,
                         budget int

);

create  table Tache(
                       TacheId int primary key  auto_increment,
                       taskdesc varchar(100) ,
                       startdate date ,
                       enddate date ,
                       projectId int ,
                       foreign key (projectId) references Project(projectId) on delete cascade


);

create  table Resource(
                          ResourceId int primary key  auto_increment,
                          name varchar(100) ,
                          detail varchar(200),
                          type varchar(100) ,
                          quantité int ,
                          fournisseur varchar(100)

);
