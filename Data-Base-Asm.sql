use [Asm-java4]

create table[user]
(
id int primary key identity,

username varchar(10) unique not null,

[password] varchar(10) not null,

email varchar(50) unique not null,

isAdmin bit not null default 0,

isActive bit not null default 1
)
go
create table video
(
id int primary key identity,

title nvarchar(255) not null,

href varchar(50) unique not null,

poster varchar(255) null,

[views] int not null default 0,

shares int not null default 0,

[description] nvarchar(255) not null,

isActive bit not null default 1
)
go
create table history
(
id int primary key identity,

userId int foreign key references [user](id),

videoId int foreign key references video(id),

viewedDate datetime not null default getDate(),

isLiked bit not null default 0,

likedDate datetime null

)