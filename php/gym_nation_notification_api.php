<?php 
	
$gymname = isset($_POST['gymname']) ? $_POST['gymname'] : '';
       if (isset($_POST['gymname'])) {   
	
	require_once('gym_nation_database_conn_link.php');
	
	//database constants
	define('DB_HOST', $db_server );
	define('DB_USER', $DB_USER);
	define('DB_PASS', $DB_PASS);
	define('DB_NAME', $gymname);
        
       }
       
	
	//connecting to database and getting the connection object
	$conn = new mysqli(DB_HOST, DB_USER, DB_PASS, DB_NAME);
        
	
	//Checking if any error occured while connecting
	if (mysqli_connect_errno()) {
		echo "Failed to connect to MySQL: " . mysqli_connect_error();
		die();
	}
        
        
        header('Contrnt-Type: app;ication/Json; charset=utf-8');
        mysqli_set_charset($conn,"utf8");
        
        
	
	//creating a query
	$stmt = $conn->prepare("SELECT _id, massage_head, massage_body, massage_time_date, massage_icon FROM notification;");
	
	//executing the query 
	$stmt->execute();
	
	//binding results to the query 
	$stmt->bind_result($_id, $massage_head, $massage_body, $massage_time_date, $massage_icon);
	
	$Notificaton = array(); 
	
	//traversing through all the result 
	while($stmt->fetch()){
		$temp = array();
		$temp['_id'] = $_id; 
	        $temp['massage_head'] = $massage_head;      
                $temp['massage_body'] = $massage_body; 
                $temp['massage_time_date'] = $massage_time_date; 
                $temp['massage_icon'] = $massage_icon; 
               
                

		array_push($Notificaton, $temp);
	}
	
	//displaying the result in json format 
	echo json_encode($Notificaton,JSON_UNESCAPED_UNICODE);
        
       
        
	
	