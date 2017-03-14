using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Com.Reactlibrary.RNLocationChange
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNLocationChangeModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNLocationChangeModule"/>.
        /// </summary>
        internal RNLocationChangeModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNLocationChange";
            }
        }
    }
}
