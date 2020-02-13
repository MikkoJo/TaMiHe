import React from 'react';
import './App.css';

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      apartments: [],
      address: ''
    }

    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleChange = this.handleChange.bind(this);

  }

  handleChange(event) {
    if (event.target.id === 'address') {
      this.setState({ address: event.target.value });
    }
  }
  
  handleSubmit(event) {
    event.preventDefault();
    console.log(this.state.langs);
    fetch("http://localhost:8080/apartment?address=" + this.state.address)
      .then(res => res.json()
        .then((data => {
          this.setState({ apartments: data })
        })
        )
        .catch(console.log)
      )
  }


  componentDidMount() {
    fetch("http://localhost:8080/apartment")
      .then(res => res.json()
        .then((data => {
          this.setState({ apartments: data })
        })
        )
        .catch(console.log)
      )
  }

  render() {
    return (
      <div>
        <h1 className="App">Kiinteistöesittely</h1>

        <div>
          <ul>
            {this.state.apartments.map(function (apar) {
              return <li key={apar.id}>
                <div>{apar.address.streetAddress} {apar.address.zipCode} {apar.address.city}</div>
                {apar.pictures.map(function (pic) {
                  return <img key={pic.id} src={pic.url} alt="" style={{ width: '300px', margin: '10px' }} />

                })}
              </li>
            })}
          </ul>
        </div>
        <form id='filter' onSubmit={this.handleSubmit}>
          <label htmlFor='address'>Osoite:</label>
          <input id='address' name='address' type='text' onChange={this.handleChange}></input><br />
          <button type='submit'>Hae Osoitteella</button>
        </form>
      </div>
    );
  }
}


export default App;
