package sttCustomerManagement.services;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
// --- <<IS-END-IMPORTS>> ---

public final class java

{
	// ---( internal utility methods )---

	final static java _instance = new java();

	static java _newInstance() { return new java(); }

	static java _cast(Object o) { return (java)o; }

	// ---( server methods )---




	public static final void javaDateToJsonDatetime (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(javaDateToJsonDatetime)>> ---
		// @sigtype java 3.5
		// [i] object:0:required javaDate
		// [o] field:0:required jsonDatetime
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		Date javaDate = (Date) IDataUtil.get( pipelineCursor, "javaDate" );
		pipelineCursor.destroy();
		
		String jsonDatetime = null;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXX");
		
		ZonedDateTime zonedDateTime = javaDate.toInstant()
		    .atZone(ZoneId.of("+00:00"));
		
		jsonDatetime = zonedDateTime.format(formatter).replace("Z", "+0000");
		
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "jsonDatetime", jsonDatetime );
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void jsonDatetimeToJavaDate (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(jsonDatetimeToJavaDate)>> ---
		// @sigtype java 3.5
		// [i] field:0:required jsonDateTime
		// [o] object:0:required javaDate
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		String jsonDateTime = IDataUtil.getString( pipelineCursor, "jsonDateTime" );
		pipelineCursor.destroy();
		
		Date javaDate = null;
		
		try {
		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		    javaDate = formatter.parse(jsonDateTime);
		} catch (ParseException e) {
		    throw new ServiceException(e);
		}
		
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "javaDate", javaDate );
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}
}

