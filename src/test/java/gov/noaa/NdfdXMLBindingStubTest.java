package gov.noaa;

import com.sun.jmx.remote.internal.Unmarshal;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.*;

class NdfdXMLBindingStubTest {

    @Test
    void latLonListZipCode() throws Exception {

        JAXBContext jaxbContext = JAXBContext.newInstance(DwmlType.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();


        NdfdXMLBindingStub bindingStub = (NdfdXMLBindingStub) new NdfdXMLLocator().getndfdXMLPort();
        String result = bindingStub.latLonListZipCode("53704");

        DwmlType dwmlType = (DwmlType) jaxbUnmarshaller.unmarshal(new StringReader(result));
        assertEquals("43.0798,-89.3875", dwmlType.getLatLonList());
        assertEquals("1.0", dwmlType.getVersion());

    }
}