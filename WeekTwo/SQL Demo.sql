-- More DDL to create a table called users
create table if not exists users (
	id int primary key generated always as identity,
	first_name varchar(30) not null,
	last_name varchar(30) not null,
	email varchar(50) not null unique,
	username varchar(64) not null unique,
	password varchar(50) not null
);

-- DDL ALTER, SET, DROP and TRUNCATE keywords

alter table users add column test integer;
alter table users alter column test set data type varchar(2);
alter table users alter column test set default 'hi';

-- Update all null values to 'hi'
update users set test = coalesce(test, 'hi');

alter table users alter column test set not null;
alter table users drop column test;

-- Truncate table - removes all table data but leave the table
truncate table users;

-- Drop table -- completely removes the table
drop table users;

-- DML Statements
-- You can insert a single value into the table
insert into users (first_name, last_name, email, username, password) values
	('Morty', 'Smith', 'morty@mail.com', 'mortysmith', 'ihaterick');

-- You can insert multiple values into the table
insert into users (first_name, last_name, email, username, password) values
	('Summer', 'Smith', 'summer@mail.com', 'summersmith', 'sssumertime'),
	('Gear', 'Head', 'gear@mail.com', 'gearhead', 'gearhead'),
	('Bird', 'Person', 'bird@mail.com', 'birdperson', 'birdwars'),
	('Rick', 'Sanchez', 'rick@mail.com', 'ricksanchez', 'ilovemorty');

-- We can update specific entries in the table with UPDATE
update users set email = 'frankenbird@mail.com' where id = 4;

-- We can also delete a specific user from the table
delete from users where id = 4;

-- DQL Queries

-- We can grab everything from a table
select * from users;

-- We can specify which columns we want returned
select first_name, last_name from users;

-- We can assign alias' to change the title of an attribute in the result set
select username as alias from users;

-- Create a table called posts with the attributes
	-- postId number and primary key
	-- autorId number
	-- content string (varargs)

-- Insert posts into table, one from each user above

-- Select all posts

-- Select a post from a specific user

-- We can use Wher to narrow down out search results
select * from users where id >2;

-- We can use the keyword LIKE with wildcards to search for strings
-- % wildcard works as a standin for 0 or more characters
select username from users where username like 'm%';
select username from users where username like '%smith';
-- _ wildcard is a standin for exactly one character
select username from users where username like 'gear_ead';
select username from users where username like '_i%';

--Sorting/ordering with the ORDER BY Keyword
select * from users order by username; 
select * from users order by username desc;

-- BETWEEN keyword example

select * from users where id between 2 and 4;

-- IN keyword example
select * from users where first_name in('Morty', 'Rick', 'Summer');

-- Creating a Many-to-one/one-to-many relationship

create table if not exists posts(
	post_id int primary key generated always as identity,
	author_id int references users(id) not null,
	wall_user_id int references users(id) not null,
	post_content varchar(500) not null
);

-- After creating posts, you cannot drop a user while posts exist
-- Because posts depends on users, you can fix this issue by using cascade

drop table users cascade;

-- Creating a many-to-many relationship with a junction table

create table if not exists post_likes_junction(
	user_id int references users(id) not null,
	post_id int references posts(post_id) not null,
	primary key(user_id, post_id)
);

-- Use your DML skills to do the following:
	-- Gear Head should post a messags on Ricks wall, Morty likes that post
	-- Morty should post a message on Ricks wall, Summer and Rick like that post
	-- Summer posts a message on Morty's wall, Morty, and Gear Head like that post 

-- Lets insert some data to play with 
insert into posts(author_id, wall_user_id, post_content) values
	(1,2, 'I just joined'),
	(1,3, 'How are you doing today'),
	(1,5, 'How is the family'),
	(2,3, 'Happy Birthday'),
	(2,5, 'That was a crazy night'),
	(3,1, 'I am doing great'),
	(3,5, 'We should do that again some time'),
	(5,1, 'Glad to see you joined'),
	(5,5, 'Thanks everyone who came out'),
	(5,2, 'We really had a great time'),
	(5,3, 'We will definitely plan to do more events');

select * from posts;

insert into post_likes_junction(user_id, post_id) values
	(2,1), (3,1),
	(2,2), (5,2),
	(5,3), (2,3), (3,3),
	(3,4), (2,4), (1,4),
	(5,5), (3,5), (2,5),
	(1,6),
	(5,7), (2,7), (3,7), (1,7),
	(1,8), (3,8),
	(3,9), (2,9), (5,9),
	(2, 10), (3,10),
	(3, 11);

select * from post_likes_junction;

select username, post_content from users u, posts p, post_likes_junction plj where plj.user_id = u.id and p.post_id = plj.post_id;

-- Aggregate Functions

select count(l.post_id) as likes, p.post_content from post_likes_junction l, posts p
where l.post_id = p.post_id
group by p.post_content
order by likes desc;

select max(username) from users;

select min(username) from users;

-- Scalar Functions

select lower(first_name) as first, lower(last_name) as last from users;

select upper(concat(first_name, last_name)) as name from users;

-- Stored Procedures don't return anything, are useful for adding elements to a table
create or replace procedure create_post(a_id int, w_id int, post varchar(500))
as $$
begin
	insert into posts(author_id, wall_user_id, post_content) values (a_id, w_id, post);
end;
$$ language 'plpgsql';

-- To use this procedure use the call keyword
call create_post(1,1, 'Gee rick, that was a great party');

select * from posts;

-- Functions return a value
create or replace function like_check(p_id int)
returns int as $body$
declare likes int;
begin
	select into likes count(*) from post_likes_junction where p_id = post_id;
	return likes;
end;
$body$ language 'plpgsql';

-- To call a function you use the select keyword
select like_check(4);

-- Sequences are just a sequence of numbers that goes from 1 to the next
create sequence counter start 1;
select nextval('counter');

create table following (
	f_id int primary key,
	follower_id int,
	followie_if int
);

-- We can use a sequence in conjunction with triggers to create auto generated field values
create or replace function ex_trigger()
returns trigger as $$
begin
	new.f_id = nextval('counter');
	return new;
end;
$$ language 'plpgsql';

-- Now we actually use that function with a trigger to auto generate the ids for us
create trigger id_trigger before insert on following for each row execute procedure ex_trigger();

insert into following(follower_id, followie_if) values (1,2);
insert into following(follower_id, followie_if) values (2,1);

select * from following;

-- View, a virtualized representation of a table or subset of a table
create view post_display as select username, post_content from posts, users where id = author_id;

select * from post_display;

-- Cursors are pointers to a temporary workspace, they hold rows returned by an sql statement
-- The set of rows it holds is known as the result set or active set

-- We use cursors to return multiple rows of data from a function
CREATE OR REPLACE FUNCTION get_user_posts(u_id int)
RETURNS refcursor AS $$
DECLARE REF refcursor;
BEGIN
	OPEN REF FOR SELECT * FROM posts WHERE author_id = u_id;
	RETURN REF;
END;
$$ LANGUAGE 'plpgsql';

-- In order to view the reference cursor we must turnoff auto commit
select get_user_posts(2);
commit;

create or replace function get_all_posts()
returns refcursor as $$
declare ref refcursor;
begin
	open ref for select u.username, p.post_id, p.author_id, p.wall_user_id, p.post_content
				 from users u, posts p
				 where u.id = p.author_id;
	return ref;
end;
$$ language 'plpgsql';

select get_all_posts();
commit;

-- Joins and Set Operators
-- Super simple join examples with the junction
select * from users u inner join posts p on u.id = p.author_id;

select * from users u full join posts p on u.id = p.author_id;

select * from users u left join posts p on u.id = p.author_id;

select * from users u right join posts p on u.id = p.author_id;

-- Get whats posts each user liked
select u.username, p2.post_content as liked_content
from users u
inner join(select * from posts p inner join post_likes_junction plj on p.post_id = plj.post_id) as p2
on u.id = p2.user_id;

-- Count users with the greatest number of posts
select u.id, u.first_name, u.last_name, count(*) as count_num from users u
left join posts p on p.author_id = u.id
group by u.id
order by count_num desc;

-- Rank the users with the most total likes
select count(u.id) as like_count, u.username
from users u
inner join (select * from posts p inner join post_likes_junction plj on p.post_id = plj.post_id) as u2 on u2.author_id = u.id
group by u.username
order by like_count desc;

select * from users u inner join (select * from posts p inner join post_likes_junction plj on p.post_id = plj.post_id) as u2 on u2.author_id = u.id;

-- Set Operators
select u.username from users u union select p.post_content from posts p, users u where u.id = p.author_id;

-- Get all posts with a like on it
select post_content from posts intersect select p.post_content from post_likes_junction plj, posts p where p.post_id = plj.post_id;

-- Get all posts without a like on them
select post_content from posts except select p.post_content from post_likes_junction plj, posts p where p.post_id = plj.post_id;

--Creating an index
-- There are other parameter you can include while creating an index, however it is not important for our training
create index uname on users(username);