-- Student table
CREATE TABLE student(
	student_id serial PRIMARY KEY,
	"first" varchar(25),
	"last" varchar(25),
	cell bigint,
	grade int
);

-- Teacher table
CREATE TABLE teacher(
	teacher_id serial PRIMARY KEY,
	"first" varchar(25),
	"last" varchar(25),
	cell int,
	email varchar(50)
);

-- Course table
CREATE TABLE courses(
	course_id serial PRIMARY KEY,
	title varchar(15),
	course_level int,
	teacher serial REFERENCES teacher
)

-- Topic table
CREATE TABLE topics(
	topic_id serial PRIMARY KEY,
	"name" varchar(15)
);

--Junction for students enrolled in course and topics they're taking
CREATE TABLE students_enrolled(
	course serial REFERENCES courses,
	student serial REFERENCES student,
	topic serial REFERENCES topics
);

INSERT INTO student ("first", "last", cell, grade)
VALUES
	('Roger', 'Chau', 5714219964, 12),
	('Jody', 'McCabe', 7032345331, 12),
	('Bella', 'Jordyn', 5718387943, 11),
	('Ramo', 'Alsomec', 7034109345, 12),
	('Day', 'Scum', 8459284384, 9);