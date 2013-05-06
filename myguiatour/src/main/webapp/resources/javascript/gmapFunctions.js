
var currentMarker = null;        

function geocodeAddress(inputAddressId, inputLatId, inputLngId, coordMaxFractDigits, map)
{
    var geocoder = new google.maps.Geocoder();
    var inputAddress = document.getElementById(inputAddressId);

    geocoder.geocode({
        'address': inputAddress.value
    }, function(results, status)

    {
        if(status == google.maps.GeocoderStatus.OK)
        {
            if(results.length > 0)
            {
                //set name of address text field, direct usage
                inputAddress.value = String(results[0].address_components[0].long_name);            
                var latLng = results[0].geometry.location;
                //set lat and lng text fields
                document.getElementById(inputLatId).value = (parseFloat(latLng.lat()), coordMaxFractDigits).toLocaleString();
                document.getElementById(inputLngId).value = (parseFloat(latLng.lng()), coordMaxFractDigits).toLocaleString();
         
                map.setCenter(latLng);
                rmtCommandGeocoder([ {
                        name : 'latitude',
                        value : results[0].geometry.location.lat()
                    }, {
                        name : 'longitude',
                        value : results[0].geometry.location.lng()
                    },{
                        name : 'cidade',
                        value : document.getElementById(inputAddressId).value
                    }]);
                marker = new google.maps.Marker({
                    map: map,
                    position: results[0].geometry.location
                });
                //markersArray.push(marker);
                latlng = marker.getPosition().lat()+","+marker.getPosition().lng();         
                var viewport = results[0].geometry.viewport;
                map.setZoom(10);
            }
        }
    });
}      

function centralizar(){
    var map = document.getElementById('formMap:cityMap');
    //map.setCenter(document.getElementById(id).value);
    //map.setZoom(13);
}
function handlePointClick(event){
    if(currentMarker == null){
        document.getElementById('lat').value = event.latLng.lat();
        document.getElementById('lng').value = event.latLng.lng();
                        
        currentMarker = new google.maps.Marker({
            position:new google.maps.LatLng(event.latLng.lat(), event.latLng.lng())
        });
        
        map.addOverlay(currentMarker);
        dlgPonto.show();
    }
}

function markerAddComplete() {  
    dlgPonto.hide();  
    var title = document.getElementById('title');  
    //currentMarker.setTitle(title.value);  
    title.value = "";  
  
    currentMarker = null;  
    
}  
function cancel() {  
    dlgPonto.hide();  
    currentMarker.setMap(null);  
    currentMarker = null;  
  
    return false;  
}  
