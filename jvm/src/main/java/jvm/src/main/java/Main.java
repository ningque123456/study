package jvm.src.main.java;

import java.net.*;
import java.util.Enumeration;

public class Main {
    public static void main(String[] args) throws UnknownHostException, SocketException {

        System.out.println(InetAddress.getLocalHost());
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost.getHostAddress());
        InetAddress inet4Address = getInet4Address();
        System.out.println(inet4Address);
    }
    private static InetAddress getInet4Address() throws SocketException {
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface netInterface = networkInterfaces.nextElement();

            if (netInterface.getDisplayName().equals("Intel(R) Wireless-AC 9560 160MHz")){
                System.out.println(netInterface.getInetAddresses().nextElement());
            }

//            Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
//            while (addresses.hasMoreElements()) {
//                InetAddress ip = addresses.nextElement();
//                if (ip instanceof Inet4Address) {
//                    return ip;
//                }
//            }
        }
        return null;
    }


}