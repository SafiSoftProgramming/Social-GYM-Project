<?php 


require_once('gym_nation_database_conn_link.php');
	
	//database constants
	define('DB_HOST', $db_server );
	define('DB_USER', $DB_USER);
	define('DB_PASS', $DB_PASS);
	define('DB_NAME', "Social_Gym");
        
       
	
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
	$stmt = $conn->prepare("SELECT _id, ad_desc, ad_gif,ad_name,ad_icon,ad_time_date,promo_code,promo_code_expiry_date,contact_details FROM adpost;");
	
	//executing the query 
	$stmt->execute();
	
	//binding results to the query 
	$stmt->bind_result($_id, $ad_desc, $ad_gif,$ad_name,$ad_icon,$ad_time_date,$promo_code,$promo_code_expiry_date,$contact_details);
	
	$adpost = array(); 
	
	//traversing through all the result 
	while($stmt->fetch()){
		$temp = array();
		$temp['_id'] = $_id; 
	        $temp['ad_desc'] = $ad_desc;      
                $temp['ad_gif'] = $ad_gif; 
                $temp['ad_name'] = $ad_name;      
                $temp['ad_icon'] = $ad_icon; 
                $temp['ad_time_date'] = $ad_time_date; 
                $temp['promo_code'] = $promo_code; 
                $temp['promo_code_expiry_date'] = $promo_code_expiry_date; 
                $temp['contact_details'] = $contact_details; 
               
               
              
		array_push($adpost, $temp);
	}
	
	//displaying the result in json format 
	echo json_encode($adpost,JSON_UNESCAPED_UNICODE);
        
       
        
	
	