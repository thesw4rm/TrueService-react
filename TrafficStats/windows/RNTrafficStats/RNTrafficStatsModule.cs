using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Traffic.Stats.RNTrafficStats
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNTrafficStatsModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNTrafficStatsModule"/>.
        /// </summary>
        internal RNTrafficStatsModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNTrafficStats";
            }
        }
    }
}
