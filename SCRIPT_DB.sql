DROP DATABASE courses_platform;
CREATE DATABASE courses_platform;
USE courses_platform;

INSERT INTO `courses_platform`.`users` (`id_user`, `email`, `full_name`, `password`, `role`, `username`) VALUES ('1', 'Estudiante@Estudiante.com', 'Estudiante', 'Estudiante', 'STUDENT', 'Estudiante');
INSERT INTO `courses_platform`.`users` (`id_user`, `email`, `full_name`, `password`, `role`, `username`) VALUES ('2', 'Instructor@Instructor.com', 'Instructor', 'Instructor', 'INSTRUCTOR', 'Instructor');

INSERT INTO `courses_platform`.`courses` (`id_course`, `course_name`, `description`, `fk_id_instructor`) VALUES ('1', 'Curso', 'Curso', '2');

INSERT INTO `courses_platform`.`enrollments` (`id_enrollment`, `enrollment_date`, `fk_id_course`, `fk_id_student`) VALUES ('1', '2024-05-30', '1', '1');

INSERT INTO `courses_platform`.`messages` (`id_message`, `message_content`, `sent_date`, `fk_id_course`, `fk_id_receiver`, `fk_id_sender`) VALUES ('1', 'EstudiantesEnviaMe`nsaje', '2024-05-30', '1', '2', '1');
INSERT INTO `courses_platform`.`messages` (`id_message`, `message_content`, `sent_date`, `fk_id_course`, `fk_id_receiver`, `fk_id_sender`) VALUES ('2', 'InstructorEnviaMensaje', '2024-05-30', '1', '1', '2');

INSERT INTO `courses_platform`.`lessons` (`id_lesson`, `content`, `lesson_title`, `fk_id_course`) VALUES ('1', 'Leccion', 'Leccion', '1');

INSERT INTO `courses_platform`.`assignments` (`id_assignment`, `assignment_title`, `description`, `due_date`, `fk_id_lesson`) VALUES ('1', 'Tarea', 'Tarea', '2024-05-30', '1');

INSERT INTO `courses_platform`.`submissions` (`id_submission`, `content`, `grade`, `submission_date`, `fk_id_assignment`, `fk_id_student`) VALUES ('1', 'Entrega', 5.0, '2024-05-30', '1', '1');


