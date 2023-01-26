package com.mattine.poc.navigation.model

import com.mattine.mattinepoc.presentation.architecture.mdoel.PresentationDestination


class UnhandledDestinationException(
    destination: PresentationDestination
) : IllegalArgumentException(
    "Navigation to ${destination::class.simpleName} was not handled."
)
