Rails.application.routes.draw do
  resources :carts do
    member do
      get 'payment'
    end
  end
  root 'items#index'
  resources :items do
    member do
      get 'add_to_cart'
      get 'remove_from_cart'
    end
  end
  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
end
