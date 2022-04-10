import React, { useState } from 'react'
import { Message, Form, Button, Input, Select } from 'semantic-ui-react'
import axios from "axios"

const provinceSelectOptions = [
    { key: 'ab', text: 'AB', value: 'AB' },
    { key: 'bc', text: 'BC', value: 'BC' },
    { key: 'mn', text: 'MN', value: 'MN' },
    { key: 'nb', text: 'NB', value: 'NB' },
    { key: 'ns', text: 'NS', value: 'NS' },
    { key: 'nl', text: 'NL', value: 'NL' },
    { key: 'nwt', text: 'NWT', value: 'NWT' },
    { key: 'on', text: 'ON', value: 'ON' },
    { key: 'pei', text: 'PEI', value: 'BC' },
    { key: 'qb', text: 'QB', value: 'QB' },
    { key: 'sk', text: 'SK', value: 'SK' },
    { key: 'yt', text: 'YT', value: 'YT' }
]

const PatientModifyProfileForm = (props) => {

    const [newProfile, setNewProfile] = useState({
        email: props.currProfile.email,
        password: props.currProfile.profile.username,
        firstName: props.currProfile.profile.firstName,
        middleName: props.currProfile.profile.middleName,
        lastName: props.currProfile.profile.lastName,
        dob: props.currProfile.profile.dob,
        buildingNumber: props.currProfile.profile.address.buildingNumber,
        street: props.currProfile.profile.address.street,
        city: props.currProfile.profile.address.city,
        province: props.currProfile.profile.address.province,
        postalCode: props.currProfile.profile.address.postalCode
    })

    /* error determines whether a message displays
     * 0 -> no message
     * -1 -> error message
     * 1 -> success message
    */
    const [error, setError] = useState(0)

    /* checks the validity of all information
     * true -> all given information is valid
     * false -> if otherwise
     */
    const formIsValid = () => {

        const numeric = /[0-9]+/
        const alphabetic = /([a-zA-Z]+[-\s]?)*[a-zA-Z]+/

        // check email
        const emailRe = /([a-zA-Z0-9]+[\.-_]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+\.?)*[a-zA-Z0-9]+/
        if (!emailRe.test(newProfile.email) && newProfile.email != '') {
            return false
        } else if (newProfile.email == '') {
            setNewProfile({...newProfile, email: props.currProfile.email})
        }

        // check password
        if (newProfile.password == '') {
            setNewProfile({...newProfile, password: props.currProfile.profile.username})
        }

        // check firstName
        if (!alphabetic.test(newProfile.firstName) && newProfile.firstName != '') {
            return false
        } else if (newProfile.firstName == '') {
            setNewProfile({...newProfile, firstName: props.currProfile.profile.firstName})
        }

        // check middleName
        if (!alphabetic.test(newProfile.middleName) && newProfile.middleName != '') {
            return false
        }

        // check lastName
        if (!alphabetic.test(newProfile.lastName) && newProfile.lastName != '') {
            return false
        } else if (newProfile.lastName == '') {
            setNewProfile({...newProfile, lastName: props.currProfile.profile.lastName})
        }

        // check dob
        const dobRegex = /[0-9]{4}-(0[0-9]|1[0-2])-([0-2][0-9]|3[0-1])/
        if (!dobRegex.test(newProfile.dob) && newProfile.dob != '') {
            return false
        } else if (newProfile.dob == '') {
            setNewProfile({...newProfile, email: props.currProfile.profile.dob})
        }

        if (!numeric.test(newProfile.buildingNumber) && newProfile.buildingNumber != '') {
            return false
        } else if (newProfile.buildingNumber == '') {
            setNewProfile({...newProfile, buildingNumber: props.currProfile.profile.address.buildingNumber})
        }

        if (newProfile.street == '') {
            setNewProfile({...newProfile, street: props.currProfile.profile.address.street})
        }

        if (newProfile.city == '') {
            setNewProfile({...newProfile, city: props.currProfile.profile.address.city})
        }

        const pcRe = /[a-zA-Z0-9]{3}\s[a-zA-Z0-9]{3}/
        if (!pcRe.test(newProfile.postalCode) && newProfile.postalCode != ''){
            return false
        } else if (newProfile.postalCode == '') {
            setNewProfile({...newProfile, postalCode: props.currProfile.profile.address.postalCode})
        }
        
        setError(1)
        return true
    }

    const handleSubmit = (e) => {
        e.preventDefault();

        if (formIsValid()) {
        
            axios.put('http://localhost:8080/patient/update', 
            {
                id: props.currProfile.id,
                email: newProfile.email,
                profile: {
                    id: props.currProfile.profile.id,
                    username: props.currProfile.profile.username,
                    password: props.currProfile.profile.username,
                    firstName: newProfile.firstName,
                    middleName: newProfile.middleName,
                    lastName: newProfile.lastName,
                    address: {
                        id: '',
                        buildingNumber: newProfile.buildingNumber,
                        street: newProfile.street,
                        city: newProfile.city,
                        province: newProfile.province,
                        postalCode: newProfile.postalCode
                    },
                    dob: newProfile.dob
                }
            }).then(res => {
                if(res.status == 200){
                    console.log(res.status)
                } else {
                    console.log(res.status)
                }
            }).catch(function(e) {
                console.log(e)
                console.log(newProfile)
            })

        } else { // inputted info is not valid
            setError(-1)
        }

    }

    return (<>
    <Form>
        <Form.Group widths='equal'>
            <Form.Field
                required
                id='firstName'
                control={Input}
                label="First Name"
                placeholder="First Name"
                onChange={e => setNewProfile({...newProfile, firstName: e.target.value})}
                value={newProfile.firstName}
            />
            <Form.Field
                id='middleName'
                control={Input}
                label="Middle Name"
                placeholder="Middle Name"
                onChange={e => setNewProfile({...newProfile, middleName: e.target.value})} value={newProfile.middleName}
            />
            <Form.Field
                required
                id='lastName'
                control={Input}
                label="Last Name"
                placeholder="Last Name"
                onChange={e => setNewProfile({...newProfile, lastName: e.target.value})} value={newProfile.lastName}
            />
            
        </Form.Group>

        <Form.Group widths='equal'>
            <Form.Field
                required
                id='dob'
                control={Input}
                label="Date Of Birth"
                placeholder="YYYY-MM-DD"
                onChange={e => setNewProfile({...newProfile, dob: e.target.value})}
                value={newProfile.dob}
                maxLength={10}
            />
            <Form.Field
                required
                id='email'
                control={Input}
                label='Email'
                placeholder='joe@schmoe.com'
                onChange={e => setNewProfile({...newProfile, email: e.target.value})} value={newProfile.email}
            />

        </Form.Group>

        <Form.Group widths='equal'>
            <Form.Field
                id='id'
                control={Input}
                label='ID'
                value={props.currProfile.id}
                disabled
            />
            
            <Form.Field
                id='username'
                control={Input}
                label='Username'
                value={props.currProfile.profile.username}
                disabled
            />
            <Form.Field
                required
                id='password'
                control={Input}
                label='Password'
                placeholder="Password"
                onChange={e => setNewProfile({...newProfile, password: e.target.value})} value={newProfile.password}
            />
        </Form.Group>

        <Form.Group>
            <Form.Field
                required
                id='postalCode'
                control={Input}
                label='Postal Code'
                placeholder={props.currProfile.profile.address.postalCode}
                onChange={e => setNewProfile({...newProfile, postalCode: e.target.value})}
                value={newProfile.postalCode}
                maxLength={7}
                width={2}
            />
            <Form.Field
                required
                id='buildingNumber'
                control={Input}
                label='Building Number'
                placeholder="1234"
                onChange={e => setNewProfile({...newProfile, buildingNumber: e.target.value})}
                value={newProfile.buildingNumber}
                width={2}
            />
            <Form.Field
                required
                id='street'
                control={Input}
                label='Street'
                placeholder='Street Name'
                onChange={e => setNewProfile({...newProfile, street: e.target.value})} value={newProfile.street}
                width={5}
            />
            <Form.Field
                required
                id='city'
                control={Input}
                label='City'
                placeholder='City'
                onChange={e => setNewProfile({...newProfile, city: e.target.value})} value={newProfile.city}
                width={4}
            />
            <Form.Field
                required
                id='province'
                control={Select}
                options={provinceSelectOptions}
                label='Province'
                placeholder='ON'
                onChange={(e, {value}) => setNewProfile({...newProfile, province: value})} value={newProfile.province}
                width={1}
            />
        </Form.Group>
        <Form.Group widths='equal'>
            
        </Form.Group>

        { error == -1 &&
            <>
            <Form error><Message error header='Error!' content='Please review the inputted information.'/></Form>
            <br/>
            </>
        }

        { error == 1 &&
            <>
            <Form success><Message success header='Success!' content='Your information has been updated. **Note: if required fields(*) are left blank, information for those fields remain the same.'/></Form>
            <br/>
            </>
        }

        <Button type='submit' content='Save changes' onClick={handleSubmit}/>

    </Form>
    </>)
}

export default PatientModifyProfileForm