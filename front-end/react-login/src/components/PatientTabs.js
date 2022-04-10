import React from 'react'
import { Tab } from 'semantic-ui-react'

import PatientProfile from '../components/PatientProfile'
import PatientSchedule from '../components/PatientSchedule'
import MedHistory from '../components/MedHistory'

const PatientTabs = (props) => {
    return (
        <Tab panes={
            [
                { menuItem: 'Profile', render: () => <Tab.Pane><PatientProfile profile={props.loggedInUser}/></Tab.Pane> },
                { menuItem: 'Upcoming Appointments', render: () => <Tab.Pane><PatientSchedule profile={props.loggedInUser}/></Tab.Pane> },
                { menuItem: 'Medical History', render: () => <Tab.Pane><MedHistory profile={props.loggedInUser}/></Tab.Pane> }
            ]
        }/>
    )
    
}

export default PatientTabs