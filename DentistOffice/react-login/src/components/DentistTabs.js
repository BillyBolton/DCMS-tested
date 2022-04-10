import React from 'react'
import { Tab } from 'semantic-ui-react'

import PatientProfile from '../components/PatientProfile'
import DentistSchedule from '../components/DentistSchedule'
import MedHistory from '../components/MedHistory'

const DentistTabs = (props) => {
    return (
        <Tab panes={[
            { menuItem: 'Profile', render: () => <Tab.Pane><PatientProfile profile={props.loggedInUser} /></Tab.Pane> },
            { menuItem: 'Medical History', render: () => <Tab.Pane><MedHistory profile={props.loggedInUser} /></Tab.Pane> }
        ]} />
    )
    
}

export default DentistTabs