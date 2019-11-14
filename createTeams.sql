create table Teams(
TeamId int primary key auto_increment,
TeamName nvarchar(15));

create table PTeams(
foreign key (TeamID, PersonID) references Teams(TeamID), People(PeopleId)
constraint PTID primary key (TeamID, PersonID));