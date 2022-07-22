package dev.enflowsoft.btech.services;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;

import java.util.List;

public class LocationService {
    Geocoder geocoder;
    List<Address> addresses;
    Location loc;

   /*  public static String GetAddressLatLong(){
        try {
            geocoder = new Geocoder(getActivity(), Locale.ENGLISH);
            addresses = geocoder.getFromLocation(x, y, 1);
            StringBuilder str = new StringBuilder();
            if (geocoder.isPresent()) {
                Toast.makeText(getApplicationContext(),
                        "geocoder present", Toast.LENGTH_SHORT).show();
                Address returnAddress = addresses.get(0);

                String localityString = returnAddress.getLocality();
                String city = returnAddress.getCountryName();
                String region_code = returnAddress.getCountryCode();
                String zipcode = returnAddress.getPostalCode();

                str.append(localityString + "");
                str.append(city + "" + region_code + "");
                str.append(zipcode + "");

                address.setText(str);
                Toast.makeText(getApplicationContext(), str,
                        Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(getApplicationContext(),
                        "geocoder not present", Toast.LENGTH_SHORT).show();
            }

// } else {
// Toast.makeText(getApplicationContext(),
// "address not available", Toast.LENGTH_SHORT).show();
// }
        } catch (IOException e) {
// TODO Auto-generated catch block

            Log.e("tag", e.getMessage());
        }
    } */
}
