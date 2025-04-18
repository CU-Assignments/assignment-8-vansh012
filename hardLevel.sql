CREATE TABLE attendance (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    attendance_status VARCHAR(10),
    date DATE DEFAULT CURRENT_DATE
);
