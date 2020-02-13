import React from 'react';
import './App.css';

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      apartments: [],
      code: '',
      name: ''
    }
  }
    componentDidMount() {
      fetch("http://localhost:8080/apartment")
        .then(res => res.json()
        .then((data => {
          this.setState({ apartments: data })
        })
        )
        .catch(console.log)
        )}

  render() {
  return (
    <div>
      <h1 className="App">Kiinteistöesittely</h1>
    
    <div>    
      <ul>
       {this.state.apartments.map(function(apar) {
         return <li key={apar.id}>
          {apar.address.streetAddress} {apar.address.zipCode} {apar.address.city}
          {apar.pictures.map(function(pic) {
            return <img key={pic.id} src={pic.url} alt="" style={{width:'300px'}} />

          })}
         </li>
       })} 
      </ul>
    </div>
    </div>
  );
  }
}


export default App;
