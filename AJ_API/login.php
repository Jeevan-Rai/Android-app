<?php

include 'connection.php';

extract($_POST);

$sql = "SELECT 	Student_ID, Fname, Lname, password FROM student WHERE email = '$email'";
$res = mysqli_query($con, $sql);

if($res->num_rows>0) {
    $sql = "SELECT * FROM user WHERE email = '$email' and password = '$pass'";
    $result = mysqli_query($con, $sql);
    if ($result->num_rows > 0) {
    while($row = $res->fetch_assoc()){
        $response['message'] = "Login success";
        $response['user'] = $row;
    }
}
else{
        $response['message'] = "Incorrect password";
        $response['user'] = null;
}
}
else{

    $response['message'] = "User not exists!";
    $response['user'] = null;

}

echo json_encode($response);


?>