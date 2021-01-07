<?php
error_reporting(E_ALL);

$imgname = isset($_POST['ImageName']) ? $_POST['ImageName'] : '';
       if (isset($_POST['ImageName'])) {  

$imsrc = base64_decode($_POST['base64']);
$fp = fopen($imgname, 'w');
fwrite($fp, $imsrc);
if(fclose($fp)){
 echo "Image uploaded";
}else{
 echo "Error uploading image";
}
}
?>