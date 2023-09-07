const Card = require('../models/card');

//GET wallet display page
const wallet = (req, res) => {
    /* function to find db count IMPORTANT
      Card.count({})
          .then((result) => {
            console.log(result);
          })
          .catch(err => {
            console.log(err);
          });
          */
      Card.find().collation({locale:'en',strength: 2}).sort({router:1})
          .then((result) => {   
          res.render('wallet', { title: 'Wallet', cards: result});
          }).catch((err) => {
              console.log(err);
          })
  }

//POST new card to wallet
const wallet_add_post = (req, res) => {
    const card = new Card(req.body);
    console.log(req.body);
    card.save()
        .then((result) => {
            res.redirect('/wallet');
        }).catch((err) => {
            console.log(err);
        })
};

//GET details from card in wallet
const wallet_details = (req, res) => {
    const id = req.params.id;
    Card.findById(id)
      .then(result => {
        res.render('details', { card: result, title: 'Card Details' });
      })
      .catch(err => {
        console.log(err);
      });
  };

//DELETE card from wallet
const wallet_delete = (req, res) => {
   const id = req.params.id;
   
   Card.findByIdAndDelete(id)
     .then(result => {
       res.json({ redirect: '/wallet' });
     })
     .catch(err => {
       console.log(err);
     });
 };

 module.exports = {
    wallet,
    wallet_details,
    wallet_add_post,
    wallet_delete
 }