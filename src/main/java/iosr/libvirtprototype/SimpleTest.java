package iosr.libvirtprototype;

import org.libvirt.Connect;
import org.libvirt.Domain;
import org.libvirt.LibvirtException;

/**
 * @author Tomasz Wawro
 */
public final class SimpleTest {

    /**
     * lal.
     */
    private SimpleTest() {
    }

    /* Stop JNA from attempting to load its libraries from the system */
    static {
        System.setProperty("jna.nosys", "true");
    }

    /**
     * @param args
     *            Commandline arguments
     */
    public static void main(final String[] args) {
        Connect conn = null;
        try {
            conn = new Connect("test:///default", true);
        } catch (LibvirtException e) {
            System.out.println("exception caught:" + e);
            System.out.println(e.getError());
        }
        try {
            Domain testDomain = conn.domainLookupByName("test");
            System.out
                    .println("Domain:" + testDomain.getName() + " id "
                            + testDomain.getID() + " running "
                            + testDomain.getOSType());
        } catch (LibvirtException e) {
            System.out.println("exception caught:" + e);
            System.out.println(e.getError());
        }
    }

}
