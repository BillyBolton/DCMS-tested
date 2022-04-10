import React, { Component } from 'react'
import { List, Grid, Table } from 'semantic-ui-react'
import axios from "axios"

export default class MHAppointment extends Component {
    state = {
        didUpdate: false,
        date: '',
        patient: '',
        staff: '',
        address: '',
        procedures: [],
        treatments: []
    }

    componentDidMount() {

        try {
            // get patient & employee name
            axios.get('http://localhost:8080/profile/findAll')
            .then(res => {
                const pn = res.data.filter(p => p.id == (this.props.appt).patientId);
                const sn = res.data.filter(p => p.id == (this.props.appt).employeeId);

                try {
                    this.setState({
                        date: (this.props.appt).startTime,
                        patient: pn[0].firstName+" "+pn[0].middleName+" "+pn[0].lastName,
                        staff: sn[0].firstName+" "+sn[0].middleName+" "+sn[0].lastName
                    })
                } catch {
                    console.log("waiting on prop")
                }
            })

            // get address
            axios.get('http://localhost:8080/branch/findByID', { params: {id: (this.props.appt).branchId} } )
            .then(res => {
                const address = res.data.address

                try {
                    this.setState({
                        address: address.buildingNumber+" "+address.street+", "+address.city+"("+address.province+"), "+address.postalCode
                    })
                } catch {
                    console.log("waiting on props")
                }
                
            }).catch(e => console.log(this.props.appt, e)) 

            // get procedures & treatments
            axios.get('http://localhost:8080/procedure/findAll').then( p => {
                // filter out procedures that weren't performed during the specified appt
                const procedures = p.data.filter( procedure => procedure.appointmentId == (this.props.appt).id )
                
                // get array of procedure ids to simplify filtering for treatments
                const procedureIds = []
                procedures.forEach( procedure => procedureIds.push(procedure.id))

                axios.get('http://localhost:8080/treatment/findAll')
                .then(t => {
                    this.setState({
                        procedures: procedures,
                        // filter out treatments that given performed during the specified appt
                        treatments: t.data.filter( treatment => procedureIds.includes(treatment.procedureId) )
                    })
                })

            })

            console.log("componentDidMount()", this.state)

        } catch {
            console.log("waiting on props")
        }
        
    }

    componentDidUpdate() {
        if (this.props.appt != undefined && this.state.didUpdate == false) {
            this.componentDidMount()
            this.setState({didUpdate: true})
            console.log("componentDidUpdate()", this.state)
        }
    }

    render() {
        return(<>
        <Grid columns={4}>
            <Grid.Column>
                <List><List.Item header='Date' description={this.state.date.substring(0, 10)}/></List>
            </Grid.Column>
            <Grid.Column>
                <List><List.Item header='Location' description={this.state.address}/></List>
            </Grid.Column>
            <Grid.Column>
                <List><List.Item header='Patient' description={this.state.patient}/></List>
            </Grid.Column>
            <Grid.Column>
                <List><List.Item header='Attending Staff' description={this.state.staff}/></List>
            </Grid.Column>
        </Grid>

        <Table celled structured>
            <Table.Header>
                <Table.Row>
                    <Table.HeaderCell width={5}>Procedure(s)</Table.HeaderCell>
                    <Table.HeaderCell>Treatment(s)</Table.HeaderCell>
                </Table.Row>
            </Table.Header>

            <Table.Body>
                {
                this.state.procedures.map(procedure => {
                    let treatments = this.state.treatments.filter(treatment => treatment.procedureId == procedure.id)
                    return (
                    <Table.Row verticalAlign='top'>
                        <Table.Cell>
                            <List>
                                <List.Item>
                                    <List.Header>{procedure.procedureCode+" x"+procedure.procedureCount}</List.Header>
                                    <List.Description><b>Tooth:</b> {procedure.tooth}</List.Description>
                                    <List.Description><i>{procedure.description}</i></List.Description>
                                </List.Item>
                            </List>
                        </Table.Cell>
                        <Table.Cell><List>
                        {
                        treatments.map(treatment => {return(<>
                            <List.Item header="Medication: " description={treatment.medication}/>
                            <List.Item header="Symptoms: " description={treatment.symptoms}/>
                            <List.Item header="Comments: " description={treatment.comments}/>
                        </>)})
                        }
                        </List></Table.Cell>
                        
                    </Table.Row>
                )
                })
                }
            </Table.Body>
        </Table>
        </>)
    }
}