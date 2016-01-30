
	public static ArrayList<Appointment> getAppointments(String xml) {
		
 		ArrayList<Appointment> appointments  = new ArrayList<Appointment>();
 		
 		if(xml == null) {
 			return null;
 		}
 		
 		
 		
 		XMLTree tree = new XMLTree();
 		tree.Load(xml, false);
 		XMLElement appointsElement = tree.RootElement;
 		if(appointsElement != null) {
 			for(XMLElement appElement : appointsElement.Children) {
 				if(appElement == null) {
 					continue;
 				}
 				Appointment appointment = new Appointment();
 				appointment.time = appElement.GetAttribute("time");
 				appointment.patient_id = appElement.GetAttribute("patient_id");
 				appointments.add(appointment);
 			}
 		}
 		
 		return appointments;
	}

